# Byanat Demo Project

This project demonstrates the usage of a simple API to fetch and filter cellular tower data.

## Controller

The `CellTowerController` class provides one main endpoint for the API:

```java
@RestController
@RequestMapping("/cell-tower")
public class CellTowerController {

    @GetMapping("/towers")
    public ResponseEntity<String> getTowers(@RequestBody TowerFilter towerFilter) throws IOException {
        // Implementation details
    }
}
```
## Endpoints

1.Get Towers

- Endpoint: `/cell-tower/towers`
- Method: `GET`
- Description: This endpoint returns cellular towers based on the provided filters as request parameters and if you didn't pass any filters it will return all the towers.
- Request Parameters:
    - `towerId` (optional, integer): Filter by tower ID.
    - `operator` (optional, string): Filter by operator.
    - `address` (optional, string): Filter by address.
    - `towerType` (optional, string): Filter by tower type.
    - `latitude` (optional, double): The latitude of the center point for the range filter. Required if you want to get nearby towers.
    - `longitude` (optional, double): The longitude of the center point for the range filter. Required if you want to get nearby towers.
    - `technology` (optional, string): Filter by technology.
    - `height` (optional, double): Filter by exact height.
    - `minHeight` (optional, double): Filter by minimum height.
    - `maxHeight` (optional, double): Filter by maximum height.
    - `range` (optional, double): The range, in kilometers, around the center point (`latitude`, `longitude`) to filter towers. Required if you want to get nearby towers.

## Usage

To use the API, start the application and make requests to the provided endpoints with the desired filters as request parameters.

Example:

- Get all towers: `GET http://localhost:8080/cell-tower/towers`
- Get towers within 5km of a specific latitude and longitude: `GET http://localhost:8080/cell-tower/towers?latitude=32.69783333&longitude=-116.9341944152&range=5`


## Dependencies

This project uses the following dependencies:

- Spring Boot
- Jackson for JSON parsing and serialization

Please ensure you have the necessary dependencies and configurations set up in your project to use the provided code.

## Docker Image

The docker image can be found here: https://hub.docker.com/repository/docker/shihabal3amri/byanat-demo/general

## Deployed Demo
- Get all towers: `GET http://ec2-15-185-36-201.me-south-1.compute.amazonaws.com:8080/cell-tower/towers`
- Get towers within 5km of a specific latitude and longitude: `GET http://ec2-15-185-36-201.me-south-1.compute.amazonaws.com:8080/cell-tower/towers?latitude=32.69783333&longitude=-116.9341944152&range=5`