package lucky.recipespringapp.com.recipespringapp.services;

import lucky.recipespringapp.com.recipespringapp.commands.UOMCommand;
import lucky.recipespringapp.com.recipespringapp.converters.UOMtoUOMCommand;
import lucky.recipespringapp.com.recipespringapp.repositories.UOMRepository;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Service
public class UOMServiceImpl implements UOMService
{
    private final UOMtoUOMCommand uoMtoUOMCommand;
    private final UOMRepository uomRepository;

    public UOMServiceImpl(UOMtoUOMCommand uoMtoUOMCommand, UOMRepository uomRepository) {
        this.uoMtoUOMCommand = uoMtoUOMCommand;
        this.uomRepository = uomRepository;
    }

    @Override
    public Set<UOMCommand> listAllUOM()
    {
        return StreamSupport.stream(uomRepository.findAll() .spliterator(),false)
                .map(uoMtoUOMCommand::convert)
                .collect(Collectors.toSet());

    }
}
