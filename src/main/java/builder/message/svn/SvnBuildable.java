package builder.message.svn;

import builder.message.svn.dto.AddressDTO;
import builder.message.svn.dto.SvnDTO;

/**
 * Created by khaitq
 * Date: 17/05/2018
 * Github:  https://github.com/quangkhai88
 */

public class SvnBuildable implements Buildable {

    @Override
    public Object build(String input) {

        SvnDTO svnDTO = new SvnDTO();
        svnDTO.setInCode(input);
        svnDTO.setNumber(input);

        return svnDTO;
    }
}
