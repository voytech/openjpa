/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
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

package org.apache.openjpa.persistence;

import javax.persistence.TupleElement;

/**
 * A single dimension of projection in query result.
 * 
 * @author Pinaki Poddar
 *
 * @param <X> type of the result
 */
public class TupleElementImpl<X> implements TupleElement<X> {
    private String _alias;
    protected final Class<X> _cls;
    private X _value;

    protected TupleElementImpl(Class<X> cls) {
        _cls = cls;
    }
    
    public final String getAlias() {
        return _alias;
    }

    protected void setAlias(String alias) {
        _alias = alias;
    }

    public Class<X> getJavaType() {
        return _cls;
    }
    
    public X getValue() { 
        return _value;
    }
    
    @SuppressWarnings("unchecked")
    public void setValue(Object x) {
        // X is unknown at compile time in TupleImpl when we construct a new Tuple. 
        // so we're stuck with this ugly cast.
        _value = (X) x;
    }
}
