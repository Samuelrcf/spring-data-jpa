package com.bookstore.spring_data_jpa.dtos;

import java.util.Set;
import java.util.UUID;

public record BookDto(String title, UUID publisherId, Set<UUID> authorsIds, String reviewComment) {

}
