package org.launchcode.WhatsSup.data;

import org.launchcode.WhatsSup.models.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TagRepository extends CrudRepository<Tag, Integer> {
}