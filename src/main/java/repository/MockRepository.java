package repository;

import domain.Member;

import java.util.List;

public interface MockRepository {
    List<Member> findAll();

    Member findByName(String name);

    Member updatePositionByName(String name, String position);

    void addMemeber(Member champion);
}

