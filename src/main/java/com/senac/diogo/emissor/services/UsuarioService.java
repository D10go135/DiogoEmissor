package com.senac.diogo.emissor.services;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.diogo.emissor.entities.Usuario;

@Service
public class UsuarioService {

    @Autowired
	private RabbitTemplate rabbitTemplate;

    public Usuario adicionarUsuario(Usuario usuario) {
              
        // Enviar uma mensagem de aviso para a fila RabbitMQ
        rabbitTemplate.convertAndSend("usuariocurso",usuario);
        
        return usuario;
    }

	
}