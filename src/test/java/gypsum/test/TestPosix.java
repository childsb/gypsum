/**
 *
 * Copyright (c) 2011 Gluster, Inc. <http://www.gluster.com>
 * This file is part of GlusterFS.
 *
 * Licensed under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied. See the License for the specific language governing
 * permissions and limitations under the License.
 *
 *
 * Base test class for GlusterFS + hadoop testing.  
 * Requires existing/working gluster volume named "hadoop-gluster".
 * 
 * The default volume name can be overridden with env variable gluster-volume
 *
 */

package gypsum.test;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple Gluster FS + Hadoop shim test.
 * 
 */
public class TestPosix{
    
    
    
    @BeforeClass
    public static void setup() throws Exception {
        /**
         * Automount = true.
         */
       
    }
    
    @AfterClass
    public static void after() throws IOException{

    }

    @org.junit.Test
    public void testBasicUserSwitch() throws Exception{
        
    }


}