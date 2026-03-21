package siakad_api.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Siswa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nama;
    private String nis;
}
