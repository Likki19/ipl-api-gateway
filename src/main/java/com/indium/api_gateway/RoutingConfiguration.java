package com.indium.api_gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

public class RoutingConfiguration {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                // Route for uploading match data
                .route("uploadMatchData", r -> r.path("/api/matches/upload")
                        .uri("http://localhost:5050"))

                // Route for fetching matches by player name
                .route("matchesByPlayer", r -> r.path("/api/matches/player/{playerName}")
                        .uri("http://localhost:5050"))

                // Route for fetching cumulative score by player name
                .route("cumulativeScore", r -> r.path("/api/player/{playerName}/cumulativeScore")
                        .uri("http://localhost:5050"))

                // Route for fetching match scores by date
                .route("matchScoresByDate", r -> r.path("/api/matches/scores")
                        .uri("http://localhost:5050"))

                // Route for fetching top batsmen
                .route("topBatsmen", r -> r.path("/api/matches/topbatsmen")
                        .uri("http://localhost:5050"))

                .build();
    }
}