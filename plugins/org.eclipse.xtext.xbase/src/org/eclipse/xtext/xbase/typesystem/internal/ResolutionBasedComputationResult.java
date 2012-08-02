/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.computation.ConformanceHint;
import org.eclipse.xtext.xbase.typesystem.references.BaseTypeComputationResult;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
public class ResolutionBasedComputationResult extends BaseTypeComputationResult {

	private final XExpression expression;
	private final ResolvedTypes resolution;

	public ResolutionBasedComputationResult(XExpression expression, ResolvedTypes resolution) {
		this.expression = expression;
		this.resolution = resolution;
	}

	public LightweightTypeReference internalGetActualExpressionType() {
		return resolution.internalGetActualType(expression);
	}

	public LightweightTypeReference internalGetActualType(JvmIdentifiableElement element) {
		return resolution.internalGetActualType(element);
	}

	public XExpression getExpression() {
		return expression;
	}

	public LightweightTypeReference internalGetExpectedExpressionType() {
		return resolution.internalGetActualType(expression);
	}
	
	public ConformanceHint getConformance() {
		TypeData typeData = resolution.getTypeData(expression, false);
		return typeData.getConformanceHint();
	}

}
