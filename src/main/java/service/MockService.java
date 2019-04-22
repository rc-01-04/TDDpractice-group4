package service;

import domain.Member;
import repository.MockRepository;

import java.util.List;

public class MockService {
    private final MockRepository mockRepository;

    public MockService(MockRepository mockRepository) {
        this.mockRepository = mockRepository;
    }

    public List<Member> findAllMembers() {
        return mockRepository.findAll();
    }

    public Member findByName(String name) {
        Member member = mockRepository.findByName(name);
        return member;
    }

    public Member updatePositionByName(String name, String position) {
        Member champion = findByName(name);
        champion.setName(position);

        return champion;
    }

    public void addMember(Member memeber){
        Member addChampion = new Member(memeber.getName(), memeber.getGender(), memeber.getCellphoneNumber(), memeber.getAge());
        mockRepository.addMemeber(addChampion);
        return;
    }
}
