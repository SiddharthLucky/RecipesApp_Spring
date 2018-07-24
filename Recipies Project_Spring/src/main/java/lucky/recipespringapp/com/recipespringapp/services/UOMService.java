package lucky.recipespringapp.com.recipespringapp.services;

import lucky.recipespringapp.com.recipespringapp.commands.UOMCommand;

import java.util.Set;

public interface UOMService
{
    Set<UOMCommand> listAllUOM();
}
