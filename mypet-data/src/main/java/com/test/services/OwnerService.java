package com.test.services;

import com.test.model.Owner;

public interface OwnerService extends CrudeService<Owner, Long> {
    Owner findByLastName(String lastName);
}
