select count(*) as FISH_COUNT
from FISH_INFO I join FISH_NAME_INFO N on I.FISH_TYPE = N.FISH_TYPE
where FISH_NAME = "BASS" OR FISH_NAME = "SNAPPER"
