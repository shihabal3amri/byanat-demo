package om.byanat.byanatdemo.celltower;

import com.fasterxml.jackson.databind.ObjectMapper;
import om.byanat.byanatdemo.celltower.types.TowerFilter;
import om.byanat.byanatdemo.celltower.types.TowerResponse;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CellTowerService {
    protected List<TowerResponse> getTowers(TowerFilter towerFilter) throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("https://k1vm1.wiremockapi.cloud/api/v1/towers");
        CloseableHttpResponse response = null;
        try {
            response = httpclient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            String jsonString = EntityUtils.toString(entity);
            ObjectMapper objectMapper = new ObjectMapper();
            TowerResponse[] towersResponse = objectMapper.readValue(jsonString, TowerResponse[].class);
            List<TowerResponse> towersList = Arrays.asList(towersResponse);
            if (towerFilter.getTowerId() != null) {
                towersList = towersList.stream()
                        .filter(tower -> tower.getTowerId() == towerFilter.getTowerId())
                        .collect(Collectors.toList());
            }
            if (towerFilter.getOperator() != null) {
                towersList = towersList.stream()
                        .filter(tower -> tower.getOperator().equalsIgnoreCase(towerFilter.getOperator()))
                        .collect(Collectors.toList());
            }
            if (towerFilter.getAddress() != null) {
                towersList = towersList.stream()
                        .filter(tower -> tower.getAddress().equalsIgnoreCase(towerFilter.getAddress()))
                        .collect(Collectors.toList());
            }
            if (towerFilter.getHeight() != null) {
                towersList = towersList.stream()
                        .filter(tower -> tower.getHeight() == towerFilter.getHeight())
                        .collect(Collectors.toList());
            }
            if (towerFilter.getTowerType() != null) {
                towersList = towersList.stream()
                        .filter(tower -> tower.getTowerType().equalsIgnoreCase(towerFilter.getTowerType()))
                        .collect(Collectors.toList());
            }
            if (towerFilter.getTechnology() != null) {
                towersList = towersList.stream()
                        .filter(tower -> tower.getTechnology().equalsIgnoreCase(towerFilter.getTechnology()))
                        .collect(Collectors.toList());
            }
            if (towerFilter.getMinHeight() != null && towerFilter.getMaxHeight() != null) {
                towersList = towersList.stream()
                        .filter(tower -> tower.getHeight() >= towerFilter.getMinHeight() && tower.getHeight() <= towerFilter.getMaxHeight())
                        .collect(Collectors.toList());
            } else if (towerFilter.getMinHeight() != null) {
                towersList = towersList.stream()
                        .filter(tower -> tower.getHeight() >= towerFilter.getMinHeight())
                        .collect(Collectors.toList());
            } else if (towerFilter.getMaxHeight() != null) {
                towersList = towersList.stream()
                        .filter(tower -> tower.getHeight() <= towerFilter.getMaxHeight())
                        .collect(Collectors.toList());
            }
            if (towerFilter.getLatitude() != null && towerFilter.getLongitude() != null && towerFilter.getRange() != null) {
                final double R = 6371; // radius of the earth in kilometers
                final double d = towerFilter.getRange(); // use range value in kilometers
                final double lat1 = Math.toRadians(towerFilter.getLatitude());
                final double lon1 = Math.toRadians(towerFilter.getLongitude());

                towersList = towersList.stream()
                        .filter(tower -> {
                            double lat2 = Math.toRadians(tower.getLatitude());
                            double lon2 = Math.toRadians(tower.getLongitude());

                            double dLat = lat2 - lat1;
                            double dLon = lon2 - lon1;
                            double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
                                    Math.cos(lat1) * Math.cos(lat2) *
                                            Math.sin(dLon/2) * Math.sin(dLon/2);
                            double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
                            double distance = R * c;
                            return distance <= d;
                        })
                        .collect(Collectors.toList());
            }
            Collections.sort(towersList, Comparator.comparingInt(TowerResponse::getTowerId));
            return  towersList;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if(response != null) {
                response.close();
            }
        }
    }
}
