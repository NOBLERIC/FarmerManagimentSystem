package Repository.Modal;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Labor {
    @Id
    private String id;
    private String phone;
    private String name;
    private String gender;
}
