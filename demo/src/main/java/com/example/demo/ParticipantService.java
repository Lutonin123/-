package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParticipantService {
    @Autowired
    private ParticipantRepository participantRepository;

    @Autowired
    private EventRepository eventRepository;

    public List<Participant> getAllParticipantsForEvent(Long eventId) {
        Optional<Event> event = eventRepository.findById(eventId);
        if (event.isPresent()) {
            return event.get().getParticipants().stream().toList();
        } else {
            return List.of();
        }
    }

    public Participant addParticipantToEvent(Long eventId, Participant participant) {
        Optional<Event> event = eventRepository.findById(eventId);
        if (event.isPresent()) {
            participant.setEvent(event.get());
            return participantRepository.save(participant);
        } else {
            return null;
        }
    }

    public Participant updateParticipant(Long id, Participant participantDetails) {
        Optional<Participant> participant = participantRepository.findById(id);
        if (participant.isPresent()) {
            Participant existingParticipant = participant.get();
            existingParticipant.setName(participantDetails.getName());
            existingParticipant.setEmail(participantDetails.getEmail());
            return participantRepository.save(existingParticipant);
        } else {
            return null;
        }
    }

    public void deleteParticipant(Long id) {
        participantRepository.deleteById(id);
    }
}
