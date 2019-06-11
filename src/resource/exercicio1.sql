Select e.event_type, max(e.value) - (select ev.value from events ev where ev.event_type = e.event_type order by ev.time desc limit 1,1) as value
from events e
group by e.event_type
having count(e.event_type) > 1
and min(e.time)
