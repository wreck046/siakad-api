package siakad_api.service;

import siakad_api.model.Siswa;
import siakad_api.repository.SiswaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SiswaService {
    private final SiswaRepository repo;

    public SiswaService(SiswaRepository repo) {
        this.repo = repo;
    }

    public List<Siswa> getAll() {
        return repo.findAll();
    }

    public Siswa save(Siswa siswa) {
        return repo.save(siswa);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public Siswa update(Long id, Siswa siswaBaru) {
        Siswa siswa = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Data tidak ditemukan"));
        
        siswa.setNama(siswaBaru.getNama());
        siswa.setNis(siswaBaru.getNis());
        
        return repo.save(siswa);
    }
    
}
