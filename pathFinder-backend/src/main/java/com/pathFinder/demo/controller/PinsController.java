package com.pathFinder.demo.controller;


import com.pathFinder.demo.domain.dto.PinsDto;
import com.pathFinder.demo.domain.entity.Pins;
import com.pathFinder.demo.repository.PinsRepository;
import com.pathFinder.demo.service.PinsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/pins")
public class PinsController {

    private final PinsService pinsService;

    @GetMapping("/get")
    @ResponseBody
    public List<Pins> getPins(@SessionAttribute(name = "userId", required = false) Long userId) {
        return pinsService.getPins(userId);
    }

    @PostMapping("/add")
    @ResponseBody
    public List<Pins> addPins(@SessionAttribute(name = "userId", required = false) Long userId,
                              @ModelAttribute List<PinsDto> pinsDtos) {
        return pinsService.savePins(userId, pinsDtos);
    }

    @DeleteMapping("/delete")
    @ResponseBody
    public List<Pins> deletePins(@SessionAttribute(name = "userId", required = false) Long userId,
                                 @ModelAttribute List<Pins> pins){
        return pinsService.deletePins(userId, pins);
    }

}
