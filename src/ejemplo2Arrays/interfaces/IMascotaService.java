package ejemplo2Arrays.interfaces;



import ejemplo2Arrays.dto.MascotaDTO;

import java.util.List;

public interface IMascotaService {
    List<MascotaDTO> listar();
    MascotaDTO porId(Integer id);
    void crear(MascotaDTO mascota);
    void editar(MascotaDTO mascota);
    void eliminar(Integer id);
    public int total();
}
