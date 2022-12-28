package faheem.microservices.pagination.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Palazzo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer palazooId;
    private String palazzoName;
    private String palazzoAddress;
    private Integer palazzoHight;
}
