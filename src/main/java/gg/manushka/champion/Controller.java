package gg.manushka.champion;

import gg.manushka.champion.model.Champion;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller implements io.swagger.api.ChampionsApi {

  @Override
  @ApiOperation(
    value = "Get all champions",
    notes = "",
    response = Champion.class,
    responseContainer = "List",
    tags = {}
  )
  @ApiResponses(
    value = {@ApiResponse(code = 200, message = "Successful operation", response = Champion.class)}
  )
  @RequestMapping(
    value = "/champions",
    produces = {"application/json"},
    method = RequestMethod.GET
  )
  public ResponseEntity<List<Champion>> getChampions() {

    Champion wukong =
        new Champion()
            .name("Wukong")
            .role(Champion.RoleEnum.TOP)
            .featured(true)
            .championId(1)
            .addSkinIdsItem(1)
            .addSkinIdsItem(2);
    Champion soraka =
        new Champion()
            .name("Soraka")
            .role(Champion.RoleEnum.SUPPORT)
            .featured(false)
            .championId(2)
            .addSkinIdsItem(3);
    Champion nami =
        new Champion()
            .name("Nami")
            .role(Champion.RoleEnum.SUPPORT)
            .featured(true)
            .championId(3)
            .addSkinIdsItem(4)
            .addSkinIdsItem(5);

    ArrayList<Champion> championList = new ArrayList<>();
    championList.add(wukong);
    championList.add(soraka);
    championList.add(nami);

    return new ResponseEntity<>(championList, HttpStatus.OK);
  }
}
