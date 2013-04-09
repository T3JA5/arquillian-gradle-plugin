/*
 * Copyright 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.arquillian.gradle.task

import org.jboss.arquillian.container.spi.Container
import org.jboss.arquillian.container.spi.client.container.DeploymentException
import org.jboss.arquillian.container.spi.client.container.LifecycleException
import org.jboss.arquillian.core.spi.Manager
import org.jboss.arquillian.gradle.utils.ArquillianContainerManager

/**
 * Arquillian undeploy task.
 *
 * @author Benjamin Muschko
 */
class ArquillianUndeploy extends ArquillianDeployableTask {
    ArquillianUndeploy() {
        super('Undeploys an archive from Arquillian container.')
    }

    /**
     * {@inheritDoc}
     */
    @Override
    void perform(Manager manager, Container container) throws DeploymentException, LifecycleException {
        logger.info 'Undeploying archive from Arquillian container.'
        ArquillianContainerManager arquillianContainerManager = new ArquillianContainerManager()
        arquillianContainerManager.undeploy(manager, container, createDeployableArchive())
    }
}
