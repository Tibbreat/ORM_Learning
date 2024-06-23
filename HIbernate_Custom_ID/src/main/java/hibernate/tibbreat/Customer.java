package hibernate.tibbreat;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "customers")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(generator = "custom-generator")
    //@GenericGenerator: Định nghĩa một custom generator.
    //                   Nó chỉ rõ tên của generator và chiến lược sẽ được sử dịng để tạo giá trị cho thuộc tính
    // name: Tên của generator. Tên này phải khớp với tên bạn chỉ định trong @GeneratedValue
    // strategy: Chỉ định cas sẽ thực hiện việc tạo giá trị ID
    @GenericGenerator(name = "custom-generator", strategy = "hibernate.tibbreat.MyIdGenerator")
    private String id;
    private String name;
}
