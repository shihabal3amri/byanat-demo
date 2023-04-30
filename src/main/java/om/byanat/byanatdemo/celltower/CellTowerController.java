package om.byanat.byanatdemo.celltower;
import com.fasterxml.jackson.databind.ObjectMapper;
import om.byanat.byanatdemo.celltower.types.TowerFilter;
import om.byanat.byanatdemo.celltower.types.TowerResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/cell-tower")
public class CellTowerController {

    @GetMapping("/towers")
    public ResponseEntity<String> getTowers(
            @RequestParam(required = false) Integer towerId,
            @RequestParam(required = false) String operator,
            @RequestParam(required = false) String address,
            @RequestParam(required = false) String towerType,
            @RequestParam(required = false) Double latitude,
            @RequestParam(required = false) Double longitude,
            @RequestParam(required = false) String technology,
            @RequestParam(required = false) Double height,
            @RequestParam(required = false) Double minHeight,
            @RequestParam(required = false) Double maxHeight,
            @RequestParam(required = false) Double range) throws IOException {

        TowerFilter towerFilter = new TowerFilter(towerId, operator, address, towerType, latitude, longitude, technology, height, minHeight, maxHeight, range);

        CellTowerService cellTowerService = new CellTowerService();
        List<TowerResponse> towersList = cellTowerService.getTowers(towerFilter);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        ObjectMapper objectMapper = new ObjectMapper();
        String towers = objectMapper.writeValueAsString(towersList);
        return new ResponseEntity<>(towers, headers, HttpStatus.OK);
    }
}
