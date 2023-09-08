package ejemplo3.service;

import ejemplo3.dto.PersonaDTO;
import ejemplo3.interfaces.IPersona;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Servicio implements IPersona {

    private List<PersonaDTO> personas;

    public Servicio() throws IOException, ClassNotFoundException {
        personas = new ArrayList<>();
    }

    @Override
    public PersonaDTO findbyCedula(String cedula) { //Encontrar solo 1
        return null;
    }

    @Override
    public List<PersonaDTO> findAll() throws IOException, ClassNotFoundException { //Encontrarlos todos
        return null;
    }

    @Override
    public void save(PersonaDTO persona) throws IOException {

    }

    @Override
    public void update(PersonaDTO persona) throws IOException {

    }

    @Override
    public void delete(PersonaDTO persona) throws IOException {

    }
}
