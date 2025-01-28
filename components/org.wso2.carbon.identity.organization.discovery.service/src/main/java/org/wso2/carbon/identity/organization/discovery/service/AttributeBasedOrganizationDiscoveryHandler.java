/*
 * Copyright (c) 2023, WSO2 LLC. (http://www.wso2.com).
 *
 * WSO2 LLC. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.carbon.identity.organization.discovery.service;

import org.wso2.carbon.identity.organization.management.service.exception.OrganizationManagementException;

import java.util.List;

/**
 * Interface for handling organization discovery types.
 */
public interface AttributeBasedOrganizationDiscoveryHandler {

    /**
     * Get the type of the organization discovery.
     *
     * @return The organization discovery type.
     */
    String getType();

    /**
     * Checks whether the organization discovery configuration is enabled in the given organization.
     *
     * @param organizationId The root organization ID.
     * @return If the organization discovery configuration is enabled.
     * @throws OrganizationManagementException The exception thrown when checking if organization discovery
     *                                         configuration is enabled.
     */
    boolean isDiscoveryConfigurationEnabled(String organizationId)
            throws OrganizationManagementException;

    /**
     * Extract the attribute value from the given organization discovery input.
     *
     * @param discoveryInput The discovery input provided by the user.
     * @return The extracted attribute value.
     */
    String extractAttributeValue(String discoveryInput);

    /**
     * Get the list of validations that are required for events triggered during organization discovery related
     * operations.
     *
     * @return the list of events.
     */
    @Deprecated
    // We don't need it anymore, if we (WSO2) or a any other user writes a custom org discovery handler, they need to
    // write matching event listeners to it and register it in the system.
    // https://github.com/wso2-extensions/identity-organization-management/blob/706acfb2f3495f36d6b9feec3c6cc6dc9a96c6df/components/org.wso2.carbon.identity.organization.discovery.service/src/main/java/org/wso2/carbon/identity/organization/discovery/service/listener/OrganizationDiscoveryUserOperationListener.java#L108-L111
    // The above implementation should be removed and should introduce a separate event listners for each discovery type.
    //
    List<String> requiredEventValidations();

    /**
     * Check if the given discovery attribute values are in valid format.
     *
     * @param attributeValues The discovery attribute values.
     * @return If the given discovery attribute values are in valid format.
     */
    boolean areAttributeValuesInValidFormat(List<String> attributeValues);
}
