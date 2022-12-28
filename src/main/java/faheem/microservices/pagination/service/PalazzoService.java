package faheem.microservices.pagination.service;

import faheem.microservices.pagination.entity.Palazzo;
import faheem.microservices.pagination.repository.PalazzoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Slf4j
@Service
public class PalazzoService {

    @Autowired
    private PalazzoRepository palazzoRepository;

    public Palazzo addPalazzo(Palazzo palazzo){
        log.info("PalazzoService.addPalazzo() method is called with palazzo item : {}",palazzo);
        Palazzo palazzoAdded = palazzoRepository.save(palazzo);
        log.info("palazzo added successfully!");
        return palazzoAdded;
    }

    public List<Palazzo> findAllPalazzo(){
        log.info("PalazzoService.findAllPalazzo() method is called...");
        return palazzoRepository.findAll();
    }

    public Palazzo getPalazzoById(Integer palazzoId){
        log.info("PalazzoService.getPalazzoById() method is called...");
        Optional<Palazzo> optionalPalazzo = palazzoRepository.findById(palazzoId);
        if(optionalPalazzo.isPresent()){
            log.info("palazzo found with palazzo id : {}",palazzoId);
            return optionalPalazzo.get();
        }
        else{
            log.error("palazzo not found with palazzoId : {}", palazzoId);
            throw new NoSuchElementException("palazzo not found with id : {}");
        }
    }

    public void removePalazzo(Integer palazzoid){
        if(palazzoRepository.findById(palazzoid).isPresent()){
            log.info("palazzo found with id :{}",palazzoid);
            palazzoRepository.deleteById(palazzoid);
            log.info("palazzo remove successfully!");
        }
        else{
            log.error("palazzo not found with palazzo id : {}",palazzoid);
            throw new NoSuchElementException("palazzo not found!");
        }
    }
}
