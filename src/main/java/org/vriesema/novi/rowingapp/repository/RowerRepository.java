package org.vriesema.novi.rowingapp.repository;
/*
 * @created:  2021-07-11
 * @project:  rowingapp
 * @author:   bartvriesema
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.vriesema.novi.rowingapp.model.rowingclub.Crew;
import org.vriesema.novi.rowingapp.model.rowingclub.Rower;

import java.util.List;

public interface RowerRepository extends JpaRepository<Rower, Long> {
    // TODO fix the findByCrew method
    List<Rower> findByCrew(Crew crew);

}
