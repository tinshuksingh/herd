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
package org.finra.herd.service.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.finra.herd.dao.NotificationRegistrationStatusDao;
import org.finra.herd.model.ObjectNotFoundException;
import org.finra.herd.model.jpa.NotificationRegistrationStatusEntity;

@Component
public class NotificationRegistrationStatusDaoHelper
{
    @Autowired
    private NotificationRegistrationStatusDao notificationRegistrationStatusDao;

    /**
     * Gets a notification registration status entity by its code, or throws an ObjectNotFoundException if not found.
     *
     * @param code the code (case insensitive)
     *
     * @return the notification registration status entity
     * @throws ObjectNotFoundException if the notification registration status entity doesn't exist
     */
    public NotificationRegistrationStatusEntity getNotificationRegistrationStatusEntity(String code) throws ObjectNotFoundException
    {
        NotificationRegistrationStatusEntity notificationRegistrationStatusEntity = notificationRegistrationStatusDao.getNotificationRegistrationStatus(code);

        if (notificationRegistrationStatusEntity == null)
        {
            throw new ObjectNotFoundException(String.format("The notification registration status \"%s\" doesn't exist.", code));
        }

        return notificationRegistrationStatusEntity;
    }
}
