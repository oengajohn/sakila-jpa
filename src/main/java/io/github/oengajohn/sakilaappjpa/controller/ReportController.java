package io.github.oengajohn.sakilaappjpa.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/report")
@Slf4j
public class ReportController {

    @GetMapping("exportFilmsPdf")
    public String exportFilmsPdf() {
        return "hello";
    }

    @GetMapping("exportFilmsExcel")
    public String exportFilmsExcel() {
        return "hello";
    }


}
