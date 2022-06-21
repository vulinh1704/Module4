package controller.restful;

import model.Province;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.IProvinceService;

@RestController
public class ProvinceRestController {
    @Autowired
    private IProvinceService provinceService;

    @GetMapping("findById/{id}")
    public Province findById(@PathVariable Long id) {
        return provinceService.findById(id).get();
    }

    @PostMapping("province")
    public Province save(@RequestBody Province province) {
        provinceService.save(province);
        return province;
    }
}
