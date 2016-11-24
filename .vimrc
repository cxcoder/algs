set tabstop=4
set shiftwidth=4
set expandtab
set autowrite
set autoindent
set number
set syntax=on
set ruler
set nocompatible
set hlsearch
set incsearch
set encoding=utf-8
set termencoding=utf-8
set fileencodings=utf-8,gb2312,gb18030,gbk

autocmd BufNewFile *.[ch],*.sh,*.java exec ":call SetTitle()"
func SetTitle() 
    if &filetype == 'sh' 
        call setline(1, "\#!/bin/bash") 
        call append(line("."),   "\#") 
        call append(line(".")+1, "\#    File Name: ".expand("%")) 
        call append(line(".")+2, "\#         Desc: xxxx ") 
        call append(line(".")+3, "\#       Author: cyhe ") 
        call append(line(".")+4, "\# Created Time: ".strftime("%F %T")) 
        call append(line(".")+5, "\#") 
        call append(line(".")+6, "") 
    else 
        call setline(1, "/**") 
        call append(line("."), " *  File Name: ".expand("%")) 
        call append(line(".")+1, " *  Desc: xxxx ") 
        call append(line(".")+2, " *  Author: cyhe ") 
        call append(line(".")+3, " *  Created Time: ".strftime("%F %T")) 
        call append(line(".")+4, " */") 
        call append(line(".")+5, "")
    endif
    if &filetype == 'c'
        call append(line(".")+6, "#include<stdio.h>")
        call append(line(".")+7, "")
    endif
endfunc 
autocmd BufNewFile * normal G
inoremap ( ()<ESC>i
inoremap [ []<ESC>i
inoremap " ""<ESC>i
inoremap { {<ESC>o}<ESC>O<TAB>
