package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/participants")
public class ParticipantController {
    @Autowired
    private ParticipantService participantService;

    @GetMapping("/event/{eventId}")
    public List<Participant> getParticipantsForEvent(@PathVariable Long eventId) {
        return participantService.getAllParticipantsForEvent(eventId);
    }

    @PostMapping("/event/{eventId}")
    public ResponseEntity<Participant> addParticipantToEvent(@PathVariable Long eventId, @RequestBody Participant participant) {
        Participant addedParticipant = participantService.addParticipantToEvent(eventId, participant);
        if (addedParticipant != null) {
            return ResponseEntity.ok(addedParticipant);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Participant> updateParticipant(@PathVariable Long id, @RequestBody Participant participantDetails) {
        Participant updatedParticipant = participantService.updateParticipant(id, participantDetails);
        if (updatedParticipant != null) {
            return ResponseEntity.ok(updatedParticipant);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteParticipant(@PathVariable Long id) {
        participantService.deleteParticipant(id);
        return ResponseEntity.noContent().build();
    }
}
