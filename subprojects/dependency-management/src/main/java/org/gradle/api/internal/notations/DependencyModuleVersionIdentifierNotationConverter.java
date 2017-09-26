/*
 * Copyright 2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.gradle.api.internal.notations;

import org.gradle.api.artifacts.ExternalModuleDependency;
import org.gradle.api.artifacts.ModuleVersionIdentifier;
import org.gradle.api.internal.artifacts.dependencies.DefaultExternalModuleDependency;
import org.gradle.internal.exceptions.DiagnosticsVisitor;
import org.gradle.internal.typeconversion.NotationConvertResult;
import org.gradle.internal.typeconversion.NotationConverter;
import org.gradle.internal.typeconversion.TypeConversionException;

public class DependencyModuleVersionIdentifierNotationConverter implements NotationConverter<ModuleVersionIdentifier, ExternalModuleDependency> {

    @Override
    public void describe(DiagnosticsVisitor visitor) {
        visitor.candidate("ModuleVersionIdentifier").example("'group:name:version')");
    }

    public void convert(ModuleVersionIdentifier notation, NotationConvertResult<? super ExternalModuleDependency> result) throws TypeConversionException {
        result.converted(new DefaultExternalModuleDependency(notation.getGroup(), notation.getName(), notation.getVersion()));
    }
}
