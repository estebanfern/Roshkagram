package com.roshka.bootcamp.ProyectoJunio.controller;

import com.roshka.bootcamp.ProyectoJunio.model.Comentario;
import com.roshka.bootcamp.ProyectoJunio.model.Foto;
import com.roshka.bootcamp.ProyectoJunio.service.ComentarioService;
import com.roshka.bootcamp.ProyectoJunio.service.FotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Controller
public class FotoComentarioController {

    @Autowired
    private FotoService fotoService;

    @Autowired
    private ComentarioService comentarioService;

    @GetMapping("/foto-comentario/{id}")
    public String getFotoComentarioById(@PathVariable long id, Model model) throws Exception{
        Optional<Foto> foto = fotoService.findById(id);
        if(foto.isPresent()){
            model.addAttribute("foto", foto.get());
            model.addAttribute("comentarios",foto.get().getListaComentarios());
        }
        return "foto-comentario";
    }

    @PostMapping("/foto-comentario")
    public void saveComentario(@RequestBody Comentario comentario){
        comentarioService.guardarComentario(comentario);
    }
}
