package com.AvirantEnterprises.InfoCollector_AE.repository;
import com.AvirantEnterprises.InfoCollector_AE.model.Data;
import org.springframework.data.jpa.repository.JpaRepository;
public interface DataRepository extends JpaRepository<Data, Long> {
}
