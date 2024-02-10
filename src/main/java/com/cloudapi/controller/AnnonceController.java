package com.cloudapi.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cloudapi.dto.AnnonceDTO;
import com.cloudapi.json.Response;
import com.cloudapi.model.Annonce;
import com.cloudapi.model.NombreAnnonceParMois;
import com.cloudapi.repository.UtilisateurRepository;
import com.cloudapi.service.FirebaseMessagingService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/api/annonces")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AnnonceController {
    @PersistenceContext
    private EntityManager entityManager;



    @Autowired
    private FirebaseMessagingService firebaseMessagingService;
    
    @PostMapping(value="/{id}/vendu", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> vendu(@PathVariable int id){
        Response response = new Response();
        try {
            response.success("vente d'une annonce", new Annonce().vendu(entityManager,id));

            
        } catch (Exception e) {
            e.printStackTrace();
            response.error(new Exception("Erreur vente d'une annonce"));
            // TODO: handle exception
        }
       
        return ResponseEntity.ok(response);
    }


    
    @GetMapping(value = "feed")
    public ResponseEntity<Response> findAnnoncesActualites(@RequestParam("iduser") int id){
        Response response = new Response();
        response.success("Feed", new Annonce().findAllActualite(entityManager, id));
        return ResponseEntity.ok(response);
    }


    @GetMapping(value = "{id}/photos")
    public ResponseEntity<Response> findAllPhotos(@PathVariable int id){
        Response response = new Response();
        response.success("Liste des photos de l'annonce N°" + id, new Annonce().findById(entityManager, id).getPhotoAnnonces());
        return ResponseEntity.ok(response);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping(value="/{id}/confirmer", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> confirmer(@PathVariable int id){
        Response response = new Response();
        response.success("Confirmer d'une annonce", new Annonce().confirmer(entityManager,id));

        try {
            
            Annonce a = (Annonce) entityManager.createNativeQuery("SELECT * FROM annonces WHERE id_annonce="+id,Annonce.class).getSingleResult();
            
            
            firebaseMessagingService.sendNotificationTo(a.getUtilisateur(), "Info Gascar app", " Votre annonce du "+a.getModele().getMarque().getNom()+" "+a.getModele().getNom()+" a été validé");
        } catch (Exception e) {
            // TODO: handle exception
        }
        
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<Response> findAll(){
        Response response = new Response();
        response.success("Liste des annonces", new Annonce().findAll(entityManager));
        return ResponseEntity.ok(response);
    }


    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Response> insert(@RequestBody ArrayList<MultipartFile> files, AnnonceDTO annonceDTO){
        Response response = new Response();
        try {
            response.success("Insertion d'une annonce", new Annonce().insert(entityManager, annonceDTO, files));
            
            
        } catch (Exception e) {
            e.printStackTrace();
            response.error(new Exception("Erreur lors de l'insertion de l'annonce"));
        }
       
        return ResponseEntity.ok(response);
    }


    @PutMapping(value="/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response>  modifier(@PathVariable int id, @RequestBody AnnonceDTO annonceDTO){
        Response response = new Response();
        response.success("Modification d'une annonce", new Annonce().update(entityManager,id, annonceDTO));
        return ResponseEntity.ok(response);
    }


    @DeleteMapping(value="/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response>  supprimer(@PathVariable int id){
        Response response = new Response();
        response.success("Suppression d'une annonce", new Annonce().delete(entityManager,id));
        return ResponseEntity.ok(response);
    }     

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(value = "/statistiques")
    public ResponseEntity<Response> findSat(@RequestParam int annee)throws Exception{
        Response response = new Response();
        response.success("Liste des benefices de l'année' "+annee, new NombreAnnonceParMois().findAByYear(entityManager, annee));
        return ResponseEntity.ok(response);
    }
}
