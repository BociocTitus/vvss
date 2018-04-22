package controller;

import model.Entry;
import repository.EntryRepository;
import repository.MemberRepository;

import java.util.List;

public class EntryController {
    private EntryRepository entryRepository;

    private MemberRepository memberRepository;

    public EntryController(MemberRepository memberRepository, EntryRepository entryRepository) {
        this.entryRepository = entryRepository;
        this.memberRepository = memberRepository;
    }

    public void addEntry(Entry entry) {
        if (memberRepository.getMembers().stream().noneMatch(member -> Integer.parseInt(member.getId()) == entry.getIdMember())) {
            throw new RuntimeException("Invalid entry member id");
        }
        if (entry.getType().equals("cost") || entry.getType().equals("income"))
            entryRepository.addEntry(entry);
        else
            throw new RuntimeException("Invalid entry type");
    }

    public List<Entry> getEntries() {
        return entryRepository.getAllEntries();
    }
}
