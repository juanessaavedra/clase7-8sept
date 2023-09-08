package ejemplo2Arrays.service;



import ejemplo2Arrays.dto.MascotaDTO;
import ejemplo2Arrays.interfaces.IMascotaService;

import java.util.ArrayList;
import java.util.List;

public class MascotaServiceImpl implements IMascotaService {

    private List<MascotaDTO> dataSource;

    public MascotaServiceImpl() {
        this.dataSource = new ArrayList<>();
    }
    @Override
    public List<MascotaDTO> listar() {
        return dataSource;
    }

    @Override
    public MascotaDTO porId(Integer id) {
        MascotaDTO resultado = null;
        for(MascotaDTO mas: dataSource){
            if(mas.getId() != null && mas.getId().equals(id)){
                resultado = mas;
                break;
            }
        }
        return resultado;
    }

    @Override
    public void crear(MascotaDTO mascota) {
        this.dataSource.add(mascota);
    }

    @Override
    public void editar(MascotaDTO mascota) {
        MascotaDTO m = this.porId(mascota.getId());
        m.setNombreMascota(mascota.getNombreMascota());
        m.setRaza(mascota.getRaza());
    }

    @Override
    public void eliminar(Integer id) {
        this.dataSource.remove(this.porId(id));
    }
    @Override
    public int total() {
        return this.dataSource.size();
    }
}
