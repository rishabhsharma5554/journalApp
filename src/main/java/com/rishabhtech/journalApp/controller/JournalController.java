package com.rishabhtech.journalApp.controller;

import com.rishabhtech.journalApp.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

@RestController
@RequestMapping("/api")
public class JournalController {

    Map<Long,JournalEntry> journalEntries = new HashMap<>();

    @GetMapping("/journals")
    public ArrayList<JournalEntry> getJournalEntry()
    {
        return new ArrayList<>(journalEntries.values());
    }

    @PostMapping("/journals")
    public String createJournal(@RequestBody JournalEntry journalEntry) {
        this.journalEntries.put(journalEntry.getId(), journalEntry);
        return "Success <200>";
    }

    @GetMapping("/journals/{journalId}")
    public JournalEntry getJournalById(@PathVariable(name="journalId") Long id)
    {
        return this.journalEntries.get(id);
    }

    @DeleteMapping("/journals/{journalId}")
    public JournalEntry deleteJournalById(@PathVariable(name="journalId") Long id)
    {
        return this.journalEntries.remove(id);
    }

    @PutMapping("/journals/{journalId}")
    public JournalEntry updateJournalyId(@PathVariable(name="journalId") Long id,@RequestBody JournalEntry journalEntry)
    {
        return journalEntries.put(id,journalEntry);
    }
}
