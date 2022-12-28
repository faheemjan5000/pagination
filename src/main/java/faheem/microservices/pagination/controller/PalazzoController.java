package faheem.microservices.pagination.controller;

import faheem.microservices.pagination.entity.Palazzo;
import faheem.microservices.pagination.service.PalazzoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/palazzo")
public class PalazzoController {

    @Autowired
    private PalazzoService palazzoService;

    @PostMapping("/add")
    public Palazzo addPalazzo(@RequestBody Palazzo palazzo){
        return palazzoService.addPalazzo(palazzo);
    }

    @GetMapping("/all")
    public List<Palazzo> getAllPalazzo(){
        return palazzoService.findAllPalazzo();
    }

    @GetMapping("/get/{palazzoId}")
    public Palazzo getPalazzoByid(@PathVariable Integer palazzoId){
        return palazzoService.getPalazzoById(palazzoId);
    }

    @DeleteMapping("/remove/{palazzoId}")
    public void deletePalazzo(@PathVariable Integer palazzoId){
        palazzoService.removePalazzo(palazzoId);
    }
}
