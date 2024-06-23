package hibernate.tibbreat;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.util.UUID;

public class MyIdGenerator implements IdentifierGenerator {

    @Override
    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) {
        // Tạo logic để tạo giá trị ID mới.
        // Ví dụ: sử dụng UUID, timestamp, hoặc kết hợp cả hai.
        return "prefix_" + UUID.randomUUID().toString();

    }
}
