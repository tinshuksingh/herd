/*
* Copyright 2015 herd contributors
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package org.finra.herd.model.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

/**
 * A business object data status.
 */
@Table(name = "bus_objct_data_stts_cd_lk")
@Entity
public class BusinessObjectDataStatusEntity extends AuditableEntity
{
    // List of common statuses
    public static final String VALID = "VALID";
    public static final String UPLOADING = "UPLOADING";
    public static final String RE_ENCRYPTING = "RE-ENCRYPTING";
    public static final String DELETED = "DELETED";
    public static final String INVALID = "INVALID";
    public static final String EXPIRED = "EXPIRED";
    public static final String ARCHIVED = "ARCHIVED";

    @Id
    @Column(name = "bus_objct_data_stts_cd")
    private String code;

    @Column(name = "bus_objct_data_stts_ds")
    private String description;

    @Column(name = "pre_rgstn_stts_fl")
    @Type(type = "yes_no")
    private Boolean preRegistrationStatus;

    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public Boolean getPreRegistrationStatus()
    {
        return preRegistrationStatus;
    }

    public void setPreRegistrationStatus(Boolean preRegistrationStatus)
    {
        this.preRegistrationStatus = preRegistrationStatus;
    }
}
