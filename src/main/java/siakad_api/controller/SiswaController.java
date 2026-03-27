package siakad_api.controller;

import siakad_api.model.Siswa;
import siakad_api.service.SiswaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/siswa")
@CrossOrigin(origins = "*")
public class SiswaController {
    
    private final SiswaService service;

    public SiswaController(SiswaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Siswa> getAll() {
        return service.getAll();
    }

    @PostMapping
    public Siswa create(@RequestBody Siswa siswa) {
        return service.save(siswa);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PutMapping("/{id}")
    public Siswa update(@PathVariable Long id, @RequestBody Siswa siswa) {
        return service.update(id, siswa);
    }
}
