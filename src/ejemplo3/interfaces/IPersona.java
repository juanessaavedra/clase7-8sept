package ejemplo3.interfaces;

import ejemplo3.dto.PersonaDTO;

import java.io.IOException;
import java.util.List;


public interface IPersona {
    PersonaDTO findbyCedula(String cedula);

    List<PersonaDTO> findAll() throws IOException, ClassNotFoundException;

    void save (PersonaDTO persona) throws IOException;
    void update (PersonaDTO persona) throws IOException;

    void delete (PersonaDTO persona) throws IOException;
}
