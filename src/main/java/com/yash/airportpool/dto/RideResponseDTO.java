@PostMapping("/request")
public RideResponseDTO requestRide(@RequestBody PassengerRequestDTO dto) {

    Passenger passenger = new Passenger();
    passenger.setName(dto.getName());
    passenger.setPickupLat(dto.getPickupLat());
    passenger.setPickupLng(dto.getPickupLng());
    passenger.setDropLat(dto.getDropLat());
    passenger.setDropLng(dto.getDropLng());
    passenger.setLuggageCount(dto.getLuggageCount());
    passenger.setSeatRequired(dto.getSeatRequired());
    passenger.setDetourToleranceKm(dto.getDetourToleranceKm());
    passenger.setStatus("REQUESTED");

    Passenger saved = passengerRepository.save(passenger);

    var ride = poolingService.assignPassenger(saved);

    if (ride == null) {
        throw new RuntimeException("No Ride Available");
    }

    double price = 100; // Temporary pricing

    return new RideResponseDTO(ride.getId(), "ASSIGNED", price);
}
