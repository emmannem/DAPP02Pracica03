/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package org.uv.DAPP02Pracica03;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author JMRes
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
