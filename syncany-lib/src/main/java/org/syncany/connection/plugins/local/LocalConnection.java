/*
 * Syncany, www.syncany.org
 * Copyright (C) 2011-2013 Philipp C. Heckel <philipp.heckel@gmail.com> 
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.syncany.connection.plugins.local;

import java.io.File;
import java.util.Map;
import java.util.TreeMap;

import org.syncany.connection.plugins.Connection;
import org.syncany.connection.plugins.PluginSetting;
import org.syncany.connection.plugins.PluginSetting.ValueType;
import org.syncany.connection.plugins.TransferManager;

/**
 * The local connection represents the settings required to create to a
 * backend based on a local (or mounted network) folder. It can be used to
 * initialize/create a {@link LocalTransferManager} and is part of
 * the {@link LocalPlugin}.  
 *  
 * @author Philipp C. Heckel
 */
public class LocalConnection extends Connection {
	private File repositoryPath;
	private Map<String, PluginSetting> settings = null;

    @Override
    public TransferManager createTransferManager() {
        return new LocalTransferManager(this);
    }

    public File getRepositoryPath() {
        return repositoryPath;
    }

    public void setRepositoryPath(File repositoryPath) {
        this.repositoryPath = repositoryPath;
    }
    
    @Override
	public void init() {
		repositoryPath = new File(getSettings().get("path").getValue());
	}
    
    

	@Override
	public Map<String,PluginSetting> getSettings() {
		if (settings == null) {
			settings = new TreeMap<String, PluginSetting>();
			settings.put("path", new PluginSetting(ValueType.STRING, true, false));
		}
		return settings;

	}

	




	
}
