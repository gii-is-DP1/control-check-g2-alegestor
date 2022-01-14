package org.springframework.samples.petclinic.feeding;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class FeedingService {

    private FeedingRepository feedingRepository;	
	
	@Autowired
	private FeedingService feedingService;

    @Autowired
	public FeedingService(FeedingRepository feedingRepository) {
		this.feedingRepository = feedingRepository;
	}	

    public List<Feeding> getAll(){
        return feedingRepository.findAll();
    }

    public List<FeedingType> getAllFeedingTypes(){
        return null;
    }

    public FeedingType getFeedingType(String typeName) {
        return feedingRepository.getFeedingType(typeName);
    }

    public Feeding save(Feeding p) throws UnfeasibleFeedingException {
        if(!p.pet.getType().equals(p.feedingType.petType)) throw new UnfeasibleFeedingException();
        else feedingRepository.save(p);
        return null;       
    }

    
}
