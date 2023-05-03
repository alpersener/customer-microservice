package com.proje.customer.core.utilities.mappers;

import org.modelmapper.ModelMapper;

public interface ModelMapperService {
    ModelMapper forRequests();
    ModelMapper forResponses();

}
